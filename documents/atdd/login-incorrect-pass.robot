*** Settings ***
Library    SeleniumLibrary
Resource    ./search-expire-keyword.robot

*** Variables ***
${url}    ${url}

*** Test Cases ***
Login ด้วย password ผิด 
    เปิดระบบ    ${url}
    แสดงหน้า login
    พิมพ์ username
    ระบุ password ผิด
    แสดง error user/password
    ปิด Browser

*** Keywords ***
ระบุ password ผิด
    Input Text     Password    3N11111
    Click Button    btnLogin