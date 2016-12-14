SELECT ga.*,
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
FROM talend_mtg.genericability ga
left join abilityword aw on ga.abilityword_abilityWordId = aw.abilitywordid
join manacost mc on ga.manacost_manaCostId = mc.manacostid
left join genericability_effectflags taef on ga.genericabilityid = taef.genericability_genericabilityId
left join genericability_costflags tacf on ga.genericabilityid = tacf.genericability_genericabilityId
group by genericabilityid
;