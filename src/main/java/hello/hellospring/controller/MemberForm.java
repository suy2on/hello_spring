package hello.hellospring.controller;

public class MemberForm { // ctrl + enter
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) { // form 전송시 이 함수 이용해서 name값 넣어줌
        this.name = name;
    }
}
