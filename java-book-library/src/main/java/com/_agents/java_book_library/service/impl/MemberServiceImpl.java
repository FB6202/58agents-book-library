package com._agents.java_book_library.service.impl;

import com._agents.java_book_library.entity.Member;
import com._agents.java_book_library.exception.types.ResourceAlreadyExistsException;
import com._agents.java_book_library.exception.types.ResourceNotFoundException;
import com._agents.java_book_library.payload.MemberDto;
import com._agents.java_book_library.repo.MemberRepository;
import com._agents.java_book_library.service.MemberService;
import com._agents.java_book_library.util.DtoMapper;
import com._agents.java_book_library.util.EntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public String addMember(MemberDto memberDto) {
        checkIfUsernameAlreadyExists(memberDto.getUsername());
        checkIfEmailAlreadyExists(memberDto.getEmail());

        Member member = EntityMapper.mapToMember(memberDto);
        memberRepository.save(member);

        log.info("New member added to DB: {}", member);
        return "Member added successfully.";
    }

    @Override
    public List<MemberDto> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(DtoMapper::mapToMemberDto)
                .collect(Collectors.toList());
    }

    @Override
    public MemberDto getMemberById(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new ResourceNotFoundException("Member", "ID", memberId)
        );
        return DtoMapper.mapToMemberDto(member);
    }

    @Override
    public String updateMember(MemberDto memberDto) {
        Member member = memberRepository.findById(memberDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Member", "ID", memberDto.getId())
        );

        if (!memberDto.getUsername().equals(member.getUsername())) {
            checkIfUsernameAlreadyExists(memberDto.getUsername());
        }
        if (!memberDto.getEmail().equals(member.getEmail())) {
            checkIfEmailAlreadyExists(memberDto.getEmail());
        }

        Member newMember = EntityMapper.mapToMember(memberDto);
        memberRepository.save(newMember);

        log.info("Member with ID '{}' updated successfully to: {}", member.getId(), newMember);
        return "Member updated successfully.";
    }

    @Override
    public String deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new ResourceNotFoundException("Member", "ID", memberId)
        );

        memberRepository.delete(member);

        log.info("Member deleted with ID '{}'.", memberId);
        return "Member deleted successfully.";
    }

    private void checkIfUsernameAlreadyExists(String username) {
        Optional<Member> optMemberUsername = memberRepository.findByUsername(username);
        if (optMemberUsername.isPresent()) {
            throw new ResourceAlreadyExistsException("Username already exists.");
        }
    }

    private void checkIfEmailAlreadyExists(String email) {
        Optional<Member> optMemberEmail = memberRepository.findByEmail(email);
        if (optMemberEmail.isPresent()) {
            throw new ResourceAlreadyExistsException("Email already exists.");
        }
    }

}
