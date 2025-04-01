select count(*) as fish_count
from fish_info fi inner join fish_name_info fn
on fi.fish_type = fn.fish_type
where fish_name = 'BASS' or fish_name = 'SNAPPER'