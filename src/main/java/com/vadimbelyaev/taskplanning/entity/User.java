package com.vadimbelyaev.taskplanning.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users", schema = "public")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    @Column(name = "login")
    private String login;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rank_id")
    private Rank rank;

    @OneToOne(mappedBy = "user")
    private Confirmation confirmation;

    @OneToOne(mappedBy = "user")
    private Statistics statistics;

    @OneToMany(mappedBy = "user")
    private List<Task> tasks;
}
