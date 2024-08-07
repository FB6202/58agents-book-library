package com._agents.java_book_library.repo;

import com._agents.java_book_library.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
