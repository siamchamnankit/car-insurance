*** Keywords ***
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

ปิด Browser
    Close Browser