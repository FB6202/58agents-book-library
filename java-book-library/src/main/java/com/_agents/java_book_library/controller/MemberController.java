package com._agents.java_book_library.controller;

import com._agents.java_book_library.payload.MemberDto;
import com._agents.java_book_library.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<String> addMember(@RequestBody MemberDto memberDto) {
        return new ResponseEntity<>(memberService.addMember(memberDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MemberDto>> getAllMembers() {
        return new ResponseEntity<>(memberService.getAllMembers(), HttpStatus.OK);
    }

    @GetMapping(path = "/{memberId}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable("memberId") Long memberId) {
        return new ResponseEntity<>(memberService.getMemberById(memberId), HttpStatus.OK);
    }

    @PutMapping(path = "/{memberId}")
    public ResponseEntity<String> updateMember(@RequestBody MemberDto memberDto) {
        return new ResponseEntity<>(memberService.updateMember(memberDto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable("memberId") Long memberId) {
        return new ResponseEntity<>(memberService.deleteMember(memberId), HttpStatus.OK);
    }

}
