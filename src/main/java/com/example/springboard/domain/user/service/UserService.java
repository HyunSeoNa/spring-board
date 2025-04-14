package com.example.springboard.domain.user.service;

import com.example.springboard.domain.user.dto.UserRequestDTO;
import com.example.springboard.domain.user.dto.UserResponseDTO;
import com.example.springboard.domain.user.entity.UserEntity;
import com.example.springboard.domain.user.entity.UserRoleType;
import com.example.springboard.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * fileName     : null.java
 * author       : hyunseo
 * date         : 2025. 4. 13.
 * description  :
 */
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * User 한 명 생성
     * @param userRequestDTO
     */
    @Transactional
    public void createOneUser(UserRequestDTO userRequestDTO) {
        String username = userRequestDTO.getUsername();
        String password = userRequestDTO.getPassword();
        String nickname = userRequestDTO.getNickname();

        // 동일한 username 이 있는지 확인
        if(userRepository.existsByUsername(username)) {
            return;
        }

        // User에 대한 Entity 생성 : DTO -> Entity 추가 정보 Set
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(passwordEncoder.encode(password));
        userEntity.setNickname(nickname);
        userEntity.setRole(UserRoleType.USER);

        // 저장
        userRepository.save(userEntity);
    }

    /**
     * User 한 명 조회
     * @param username
     * @return
     */
    @Transactional
    public UserResponseDTO readOneUser(String username) {
        UserEntity entity = userRepository.findByUsername(username).orElseThrow();

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUsername(entity.getUsername());
        userResponseDTO.setNickname(entity.getNickname());
        userResponseDTO.setRole(entity.getRole().toString());

        return userResponseDTO;
    }

    /**
     * User 전체 조회
     * @return
     */
    @Transactional
    public List<UserResponseDTO> readAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();

        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        for(UserEntity userEntity : userEntities) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.setUsername(userEntity.getUsername());
            userResponseDTO.setNickname(userEntity.getNickname());
            userResponseDTO.setRole(userEntity.getRole().toString());

            userResponseDTOS.add(userResponseDTO);
        }

        return userResponseDTOS;
    }


    /**
     * 로그인용 User 조회
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow();

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .roles(userEntity.getRole().toString())
                .build();
    }

    /**
     * User 한 명 수정
     * @param userRequestDTO
     * @param username
     */
    @Transactional
    public void updateOneUser(UserRequestDTO userRequestDTO, String username) {
        // 기존 User 정보 읽기
        UserEntity userEntity = userRepository.findByUsername(username).orElseThrow();

        // 비밀번호를 변경하는 경우
        if(userRequestDTO.getPassword() != null && !userRequestDTO.getPassword().isEmpty()) {
            userEntity.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        }

        // 닉네임을 변경하는 경우
        if(userRequestDTO.getNickname() != null && !userRequestDTO.getNickname().isEmpty()) {
            userEntity.setNickname(userRequestDTO.getNickname());
        }

        userRepository.save(userEntity);
    }

    /**
     * User 한 명 삭제
     * @param username
     */
    @Transactional
    public void deleteOneUser(String username) {
        userRepository.deleteByUsername(username);
    }

    /**
     * User 접근 권한 체크
     * @param username
     * @return
     */
    public boolean isAccess(String username) {
        // 현재 로그인 한 User
        String sessionUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        // 현재 로그인 되어 있는 User role
        String sessionRole = SecurityContextHolder.getContext().getAuthentication().getAuthorities().iterator().next().getAuthority();

        // 수직적으로 Admin이면 무조건 접근 가능
        if("ROLE_ADMIN".equals(sessionRole)) {
            return true;
        }

        // 수평적으로 특정 행위를 수행할 username에 대해 세션(현재 로그인한) username과 같은지
        if(username.equals(sessionUsername)) {
            return true;
        }

        // 나머지 다 불가
        return false;
    }
}
