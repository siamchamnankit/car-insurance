*** Settings ***
Library    SeleniumLibrary
Test Template    Search ประกันชั้น 3
#Suite Setup    เข้า Web Browser URL http://Google.com
#Suite Teardown    ปิด Browser
Resource    ./search-expire-keyword.robot

*** Variables ***
${url}    ${url}

*** Test Cases ***
Search ประกันชั้น 3 กณิกนันต์     2   กณิกนันต์  

*** Keywords ***
Search ประกันชั้น 3
    [Arguments]    ${rownum}    ${customer}
    เปิดระบบ    ${url}
    แสดงหน้า login
    พิมพ์ username
    ระบุ password ถุกต้อง
    แสดงหน้าค้นหา
    กดปุ่มค้นหา
    แสดงผล 5 รายการ
    เลือกรายการ     ${rownum}
    แสดงชื่อ    ${customer}
    แสดงประกันถ้าประกันเดิมชั้น 3
    ปิด Browser


แสดงประกันถ้าประกันเดิมชั้น 3
    Page Should Contain    ความคุ้มครอง รถเก๋ง/กระบบ 4 ประตู จำนวน 7 ที่นั่ง   
    Page Should Contain    เบี้ยประกันภัยเริ่มต้นที่ 8,400 บาท
    Page Should Contain    เบี้ยประกันภัย 8,888 บาท รถเก๋ง ซ่อมอู่


