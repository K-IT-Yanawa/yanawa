package com.app.yanawa.controller.charging;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/charginghomepage/payment")
public class PaymentController {

    // 부트페이 결제 완료 후 콜백을 처리하는 엔드포인트
    @PostMapping("/callback")
    public Map<String, Object> paymentCallback(@RequestBody Map<String, Object> payload) {
        // 결제 콜백 데이터 확인
        System.out.println("부트페이 결제 콜백 데이터: " + payload);

        // 결제 처리 로직 (예: DB 저장, 결제 상태 업데이트 등)
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "결제 콜백 처리가 완료되었습니다.");

        return response; // 부트페이에 결제 처리 결과 전송
    }

    // 결제 완료 후 결과 페이지로 이동
    @RequestMapping("/complete")
    public ModelAndView paymentComplete() {
        // 결제 완료 시 mainPage/main으로 이동
        return new ModelAndView("redirect:/mainPage/main");
    }

    // 결제 실패/취소 후 결과 페이지로 이동
    @RequestMapping("/cancel")
    public ModelAndView paymentCancel() {
        // 결제 취소 시 mainPage/main으로 이동
        return new ModelAndView("redirect:/mainPage/main");
    }
}
