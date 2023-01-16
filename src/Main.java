/*
You are given two tables, tasks and reports with the following structure:
create table tasks(
id integer not null,
name varchar(40) not null,
unique (id)
);
create table reports(
id integer not null,
task_id integer not null,
candidate varchar(40) not null,
score integer not null,
unique (id),
);
Your task is to write a SQL query which assigns a difficulty rating to each task having at least one solution.
The difficulty of the task depends on the average score of all the candidate's solutions for this task.
It is possible that one candidate have submitted multiple solutions for the same task. In that case,
all the solutions should be included in the average score calculation.
There are three difficulties: Easy, Medium and Hard. The difficulty is assigned as follows:
if the average score for the task is lower than or equal to 20, then its difficulty is Hard;
if the average score for the task is greater than 20 and lower than or equal to 60, then its difficulty is Medium;
if average score for the task is greater than 60, then its difficulty is Easy.
For example if the average score for the task is 50, then its difficulty is medium because the average score
is greater than 20 but less than 60.
Your query should return a table containing three columns: task_id, task_name and difficulty. Difficulty of the task
being one of the possible strings 'easy', 'medium' or 'hard'. Rows should be ordered by task_id. If no solutions
exists for a task, that task should not appear in the result table. The table should have columns names as shown in the example below.
Given:
tasks table:
id | name
  -----+-------------
   101 | MinDist
   123 | Equi
   142 | Median
   300 | Tricoloring
reports table:
id | task_id  | candidate         | score
  ----+----------+-------------------+--------
   13 | 101      | John Smith        | 100
   24 | 123      | Delaney Lloyd     | 34
   37 | 300      | Monroe Jimenez    | 50
   49 | 101      | Stanley Price     | 45
   51 | 142      | Tanner Sears      | 37
   68 | 142      | Lara Fraser       | 3
   83 | 300      | Tanner Sears      | 0
Your query should return the following result:

task_id | task_name    | difficulty
   ---------+--------------+------------
        101 | MinDist      | Easy
        123 | Equi         | Medium
        142 | Median       | Hard
        300 | Tricoloring  | Medium


 */



