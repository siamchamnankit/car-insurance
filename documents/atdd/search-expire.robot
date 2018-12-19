*** Settings ***
Library    SeleniumLibrary
Test Template    Search ประกันชั้น 1
#Suite Setup    เข้า Web Browser URL http://Google.com
#Suite Teardown    ปิด Browser

*** Test Cases ***
Search ประกันชั้น 1 เพลิน    4   เพลิน
Search ประกันชั้น 1 สบาย    5   สบาย  


*** Keywords ***
Search ประกันชั้น 1
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
    แสดงประกันถ้าประกันเดิมชั้น 1
    ปิด Browser

เปิดระบบ
    Open Browser    http://68.183.189.35    chrome

แสดงหน้า login
    Page Should Contain      Member Login

พิมพ์ username
    Input Text     username    prathan

ระบุ password ถุกต้อง
    Input Text     password    3Nj0y3819
    Click Button    btnLogin

แสดงหน้าค้นหา
    Page Should Contain     Customer List

กดปุ่มค้นหา
    Click Button    btnSearch

แสดงผล 5 รายการ
    Page Should Contain     Total found 5 record

เลือกรายการ
    [Arguments]    ${rownum}
    Click Element   //*[@id="tb-result"]/tbody/tr[${rownum}]

แสดงชื่อ
    [Arguments]    ${customer}
    Page Should Contain     ${customer}

แสดงประกันถ้าประกันเดิมชั้น 1
    Element Should Contain    ins_title1   ประกันรถยนต์ชั้น 1  
    Element Should Contain    ins_title2   เมืองไทย 3+ คุ้มเว่อร์
    Element Should Contain    ins_title3   เมืองไทยขับดียกกำลัง ยกกำลัง 8

ปิด Browser
    Close Browser
