package com.app.yanawa.repository.member;

import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.domain.team.TeamDTO;
import com.app.yanawa.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

//    회원가입
    public void save(MemberVO memberVO) {
        memberMapper.insert(memberVO);
    }

//    이메일 중복
    public boolean existsByEmail(String email) {
        return memberMapper.countByEmail(email) > 0; // 0보다 크면 중복
    }

//    닉네임 중복
    public boolean existsByNickName(String nickname) {
        return memberMapper.countByNickname(nickname) > 0; // 0보다 크면 중복
    }

//    카카오 이메일로 회원조회
    public Optional<MemberVO> findByMemberKakaoEmail(String memberKakaoEmail){
        return memberMapper.selectByMemberKakaoEmail(memberKakaoEmail);
    }


//    팀 생성 => 회원 이름, 이메일, 전화번호 조회
    public Optional<MemberDTO> findMemberByMemberId(Long Id) {
        return memberMapper.selectMemberByMemberId(Id);
    }
}
