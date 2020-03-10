package com.example.kotlininaction.javaAnonymousInnerClasses;

public class ClassToTestListener {

    public void tryListener(){

        OuterClassButton button = new OuterClassButton();
        button.addOnButtonClickListener(new OuterClassButton.ButtonClickListener() {
            @Override
            public void buttonClicked(ClickEvent e) {
                System.out.println("clicked");
            }
        });
        button.click();
    }
}


