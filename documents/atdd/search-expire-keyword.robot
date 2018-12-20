#http://68.183.189.35:8080/bw0-web/
*** Keywords ***
เปิดระบบ 
    [Arguments]     ${url}
    Open Browser     ${url}    chrome

แสดงหน้า login
    Page Should Contain      Member Login

พิมพ์ username
    Input Text     username    prathan

ระบุ password ถุกต้อง
    Input Text     password    3Nj0Y8319
    Click Button    id:btnLogin

แสดงหน้าค้นหา
    Wait Until Page Contains     Customer List

กดปุ่มค้นหา
    Click Button    id:btnSearch

แสดงผล 5 รายการ
    Page Should Contain     Total found 5 record

เลือกรายการ
    [Arguments]    ${rownum}
    Click Element   //*[@id="tb-result"]/tbody/tr[${rownum}]

แสดงชื่อ
    [Arguments]    ${customer}
    Page Should Contain     ${customer}

ปิด Browser
    Close Browser

แสดง error user/password
    Alert Should Be Present     Not User    ACCEPT    40