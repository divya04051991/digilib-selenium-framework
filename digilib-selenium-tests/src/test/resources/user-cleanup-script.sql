with
       aafUser as(delete from aaf_user where user_principal in (userPrincipals) returning user_id, user_principal),
       aafUserRole as(delete from aaf_user_role  where user_id in (select user_id from aafUser ) returning user_id),
       userProfile as(delete from user_profile  where user_principal in (select user_principal from aafUser ) returning user_profile_id, user_principal),
       appUserProfile as (delete from app_user_profile where user_profile_id in (select user_profile_id from userProfile) returning user_profile_id),
       cjfUser as(delete from cjf_user where login in (select user_principal from aafUser) returning login),
       cjfUserTablePreferences as(delete from cjf_user_table_preferences where user_principal in (select user_principal from aafUser) returning user_principal)
       select aafUser.user_id, aafuser.user_principal from aafUser left join aafUserRole on aafUser.user_id = aafUserRole.user_id;