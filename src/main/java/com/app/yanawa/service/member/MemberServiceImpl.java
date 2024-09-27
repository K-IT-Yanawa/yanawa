package com.app.yanawa.service.member;

import com.app.yanawa.domain.member.MemberDTO;
import com.app.yanawa.domain.member.MemberVO;
import com.app.yanawa.mapper.member.MemberMapper;
import com.app.yanawa.repository.member.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    private final MemberMapper memberMapper;

    //   회원가입
    @Override
    public void join(MemberDTO memberDTO) {
        // 비밀번호 두 번 입력 받은 것 비교
        if (!memberDTO.getMemberPassword().equals(memberDTO.getConfirmPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        // 비밀번호가 일치할 경우 DB에 저장
        memberDAO.save(memberDTO.toVO());
    }

    //    이메일 중복
    @Override
    public boolean isEmailDuplicate(String email) {
        return memberDAO.existsByEmail(email);
    }

    //    닉네임 중복
    @Override
    public boolean isNickNameDuplicate(String nickname) {
        return memberDAO.existsByNickName(nickname);
    }

    //     로그인
    @Override
    public Optional<MemberVO> login(String email, String password) {
        return memberMapper.selectByMemberEmailAndMemberPassword(email, password);
    }

    @Override
    public Optional<MemberDTO> getMember(Long id) {
        return memberDAO.findMemberByMemberId(id);
    }
}