create or replace view KeywordAbilityInstanceJoin as

SELECT kai.keywordabilityinstanceid, kai.rawtext,
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
	mc.typedratio as ability_typedratio,
    
    keywordabilityid,
	abilitydef,
	actionspeed,
	easescosts,
	functionsinbattlefield,
	functionsingraveyard,
	functionsinhand,
	hascost,
	hastargets,
	isactivated,
	isadditionalcost,
	isalternatecost,
	iscontinuous,
	isevasion,
	istriggered,
	reducescost,
	modifiedresolution
FROM talend_mtg.keywordabilityinstance kai
join keywordability ka on kai.ability_keywordabilityId = ka.keywordabilityId
join manacost mc on kai.manacost_manaCostId = mc.manacostid
left join keywordabilityinstance_effectflags taef on kai.keywordabilityinstanceid = taef.keywordabilityinstance_keywordabilityinstanceId
left join keywordabilityinstance_costflags tacf on kai.keywordabilityinstanceid = tacf.keywordabilityinstance_keywordabilityinstanceId
group by keywordabilityinstanceid
;