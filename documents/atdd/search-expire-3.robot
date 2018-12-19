*** Settings ***
Library    SeleniumLibrary
Test Template    Search ประกันชั้น 3
#Suite Setup    เข้า Web Browser URL http://Google.com
#Suite Teardown    ปิด Browser
Resource    ./search-expire-keyword.robot

*** Test Cases ***
Search ประกันชั้น 3 กณิกนันต์     3   กณิกนันต์  

*** Keywords ***
Search ประกันชั้น 3
    [Arguments]    ${rownum}    ${customer}
    เปิดระบบ
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
    Element Should Contain    ins_title1   ประกันรถยนต์ชั้น 1  
    Element Should Contain    ins_title2   เมืองไทย 3+ คุ้มเว่อร์
    Element Should Contain    ins_title3   เมืองไทยขับดียกกำลัง ยกกำลัง 8


