create or replace view CardAdditionalCostJoin as

select concat(cwp.cardName, ' ', aa.genericAbilityId) as abilityKey, 
	cwp.*,
	aa.*,
	ability_cmc + card_cmc as combined_cmc,
    ability_hasx | card_hasx as combined_hasx,
    ability_isblack | card_isblack as combined_isblack,
    ability_isblue | card_isblue as combined_isblue,
    ability_iscolorless | card_iscolorless as combined_iscolorless,
    ability_isgreen | card_isgreen as combined_isgreen,
    ability_isred | card_isred as combined_isred,
    ability_iswhite | card_iswhite as combined_iswhite,
    ability_typed + card_typed as combined_typed,
    (ability_typed + card_typed) / (ability_cmc + card_cmc)   as combined_typedratio,
    
    (ability_cmc * 3) + card_cmc as tripleuse_cmc,
    (ability_typed * 3) + card_typed as tripleuse_typed,
    ((ability_typed * 3) + card_typed) / ((ability_cmc * 3) + card_cmc) as tripleuse_typedratio
    
    
	
from CardWithPrices cwp
join GenericAbilityJoin aa on aa.genericAbilityId = cwp.additionalcost_genericabilityid