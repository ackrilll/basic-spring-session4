package com.sparta.basicspringsession4.repository;

import com.sparta.basicspringsession4.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
