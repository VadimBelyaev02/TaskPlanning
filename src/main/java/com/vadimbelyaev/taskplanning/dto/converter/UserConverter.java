package com.vadimbelyaev.taskplanning.dto.converter;

import com.vadimbelyaev.taskplanning.dto.UserDto;
import com.vadimbelyaev.taskplanning.entity.Rank;
import com.vadimbelyaev.taskplanning.entity.User;
import com.vadimbelyaev.taskplanning.exception.NotFoundException;
import com.vadimbelyaev.taskplanning.repository.RankRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserConverter {

    private final RankRepository rankRepository;

    public UserConverter(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    public UserDto convertToDto(User user) {
        UUID id = user.getId();
        String login = user.getLogin();
        UUID rankId = user.getRank().getId();

        return UserDto.builder()
                .id(id)
                .login(login)
                .rankId(rankId)
                .build();
    }

    public User convertToEntity(UserDto userDto) {
        UUID id = userDto.getId();
        String login = userDto.getLogin();

        Rank rank = rankRepository.findById(userDto.getRankId()).orElseThrow(() ->
                new NotFoundException("Rank with id = " + userDto.getRankId() + " is not found")
        );

        return User.builder()
                .id(id)
                .login(login)
                .rank(rank)
                .build();
    }
}
