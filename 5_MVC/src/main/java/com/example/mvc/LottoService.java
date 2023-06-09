package com.example.mvc;

import org.springframework.stereotype.Service;

@Service
public class LottoService {
    private int hits = 0;

    // 누군가 방문했을 때 호출하는 메소드
    public int addHit(){
        return ++hits;
    }
}
