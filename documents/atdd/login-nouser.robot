*** Settings ***
Library    SeleniumLibrary
Resource    ./search-expire-keyword.robot

*** Variables ***
${url}    ${url}

*** Test Cases ***
Login ด้วย user ผิด 
    เปิดระบบ    ${url}
    แสดงหน้า login
    พิมพ์ username ผิด
    ระบุ password ถุกต้อง
    แสดง error user/password
    ปิด Browser

*** Keywords ***
พิมพ์ username ผิด
    Input Text     username    prathan11