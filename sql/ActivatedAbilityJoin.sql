create or replace view activatedabilityjoin as

SELECT aa.activatedabilityid,
	aa.cost,
	aa.effect,
    aw.abilitydef, 
    GROUP_CONCAT(aacf.costFlags SEPARATOR ', ') as costFlags, 
    GROUP_CONCAT(aaef.effectFlags SEPARATOR ' ')  as effectFlags,
	mc.cmc as ability_cmc,
	mc.hasx as ability_hasx,
	mc.isblack as ability_isblack,
	mc.isblue as ability_isblue,
	mc.iscolorless as ability_iscolorless,
	mc.isgreen as ability_isgreen,
	mc.isred as ability_isred,
	mc.iswhite as ability_iswhite,
	mc.typed as ability_typed,
	mc.typedratio as ability_typedratio
FROM talend_mtg.activatedability aa
left join abilityword aw on aa.abilityword_abilityWordId = aw.abilitywordid
join manacost mc on aa.manacost_manaCostId = mc.manacostid
left join activatedability_effectflags aaef on aa.activatedabilityid = aaef.ActivatedAbility_activatedAbilityId
left join activatedability_costflags aacf on aa.activatedabilityid = aacf.ActivatedAbility_activatedAbilityId
group by activatedabilityid
;