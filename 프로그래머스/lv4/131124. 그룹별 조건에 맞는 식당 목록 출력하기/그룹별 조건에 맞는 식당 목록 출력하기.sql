-- 코드를 입력하세요
SELECT member_profile.member_name, rest_Review.review_text, date_format(rest_review.review_date, '%Y-%m-%d') as review_date
from member_profile inner join rest_review
on member_profile.member_id = rest_review.member_id
where member_profile.member_id = (
select member_id from rest_review
group by member_id
order by count(*) desc limit 1)
order by rest_review.review_date, rest_review.review_text