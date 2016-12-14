SELECT ta.*,
    aw.abilitydef, 
    GROUP_CONCAT(tacf.costFlags SEPARATOR ', ') as costFlags, 
    GROUP_CONCAT(taef.effectFlags SEPARATOR ' ')  as effectFlags,
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
FROM talend_mtg.triggeredability ta
left join abilityword aw on ta.abilityword_abilityWordId = aw.abilitywordid
join manacost mc on ta.manacost_manaCostId = mc.manacostid
left join triggeredability_effectflags taef on ta.triggeredabilityid = taef.triggeredability_triggeredabilityId
left join triggeredability_costflags tacf on ta.triggeredabilityid = tacf.triggeredability_triggeredabilityId
group by triggeredabilityid
;