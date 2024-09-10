package com.sparta.basicspringsession4.service;

import com.sparta.basicspringsession4.dto.*;
import com.sparta.basicspringsession4.entity.Member;
import com.sparta.basicspringsession4.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberSaveResponseDto saveMember(MemberSaveRequestDto memberSaveRequestDto) {
        Member member = new Member(memberSaveRequestDto.getName());
        Member savedMember = memberRepository.save(member);
        return new MemberSaveResponseDto(savedMember.getId(), savedMember.getName());
    }

    public List<MemberGetResponseDto> getMembers() {
        List<Member> members = memberRepository.findAll();
        List<MemberGetResponseDto> dtoList = new ArrayList<>();
        for (Member member : members) {
            MemberGetResponseDto memberGetResponseDto = new MemberGetResponseDto(member.getName());
            dtoList.add(memberGetResponseDto);
        }
        return dtoList;
    }

    public MemberDetailResponseDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()->new NullPointerException("해당 멤버를 찾을 수 없습니다."));
        return new MemberDetailResponseDto(member.getId(), member.getName());
    }

    @Transactional
    public MemberUpdateResponseDto updateMember(Long memberId, MemberUpdateRequestDto memberUpdateRequestDto ) {
        Member member = memberRepository.findById(memberId).orElseThrow(()->new NullPointerException("해당 멤버를 찾을 수 없습니다."));
        member.update(memberUpdateRequestDto.getName());
        return new MemberUpdateResponseDto(member.getId(),member.getName());
    }

    @Transactional
    public void deleteMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()->new NullPointerException("해당 멤버를 찾을 수 없습니다."));
        memberRepository.delete(member);
    }
}
