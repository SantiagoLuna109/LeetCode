SELECT Department, Employee, Salary FROM (
SELECT d.name AS Department, 
       e.name AS Employee, 
       e.salary AS Salary, 
       DENSE_RANK() OVER (
           PARTITION BY d.name
           ORDER BY e.salary DESC
       ) AS salary_rank

FROM department d
JOIN employee e
ON d.ID = e.departmentId
ORDER BY 4
) AS ranked

WHERE salary_rank <=3