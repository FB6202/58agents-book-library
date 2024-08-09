package com._agents.java_book_library.service;

import com._agents.java_book_library.payload.MemberDto;

import java.util.List;

public interface MemberService {

    String addMember(MemberDto memberDto);

    List<MemberDto> getAllMembers();

    MemberDto getMemberById(Long memberId);

    String updateMember(MemberDto memberDto);

    String deleteMember(Long memberId);

}
