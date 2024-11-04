package com.ohgiraffers.jsp.service;

public class MenuPriceCalculator {

    // 전달 받은 인자로 계산하는 메서드
    public int calcTotalPrice(String menuName, int amount) {

        int totalPrice = 0;
        switch (menuName){
            case "햄버거" :
                totalPrice = 9000 * amount; break;
            case "짜장면" :
                totalPrice = 7000 * amount; break;
            case "불고기백반" :
                totalPrice = 11000 * amount; break;
            case "순댓국" :
                totalPrice = 8000 * amount; break;
        }
        return totalPrice;
    }
}


