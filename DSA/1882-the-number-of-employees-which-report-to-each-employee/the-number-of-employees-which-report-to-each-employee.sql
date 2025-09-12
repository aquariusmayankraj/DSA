SELECT 
    s.employee_id,
    s.name,
    COUNT(e.reports_to) AS reports_count,
    ROUND(AVG(e.age)) AS average_age
FROM Employees e
JOIN Employees s
    ON s.employee_id = e.reports_to
GROUP BY s.employee_id, s.name
ORDER BY s.employee_id;
