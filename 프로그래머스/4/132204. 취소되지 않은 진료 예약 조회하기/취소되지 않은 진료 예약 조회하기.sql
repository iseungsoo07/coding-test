SELECT 
    a.apnt_no,
    p.pt_name,
    p.pt_no,
    a.mcdp_cd,
    d.dr_name,
    a.apnt_ymd
FROM APPOINTMENT a
JOIN PATIENT p on a.pt_no = p.pt_no
JOIN DOCTOR d on a.mddr_id = d.dr_id
WHERE TO_CHAR(a.apnt_ymd, 'YYYYMMDD') = '20220413' AND a.apnt_cncl_yn = 'N' AND a.mcdp_cd = 'CS'
ORDER BY a.apnt_ymd;