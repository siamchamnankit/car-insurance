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
    พิมพ์ username
    พิมพ์ password
    กดปุ่ม login
    แสดงหน้าค้นหา
    กดปุ่มค้นหา
    แสดงผล 5 รายการ
    เลือกรายการ     ${rownum}
    แสดงชื่อ    ${customer}
    แสดงประกัน

เปิดระบบ
    Open Browser    http://Google.com    chrome

พิมพ์ username
    Input Text     username    prathan

พิมพ์ password
    Input Text     password    3Nj0y3819

กดปุ่ม login
    Click Button    login

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

แสดงประกัน
    Page Should Contain     ประกันรถยนต์ชั้น 1    
