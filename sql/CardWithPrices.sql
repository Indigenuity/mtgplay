create or replace view CardWithPrices as

select wc.card_cardid,
	wc.wcardid,
    wc.additionalcost_genericabilityid,
	c.cardName, 
	toc.tcgPrice,
    toc.tcgFoilPrice,
    toc.cardHoarderPrice,
    toc.cardHoarderFoilPrice,
    toc.draftAverage,
    toc.cubeAverage,
    mc.cmc as card_cmc,
	mc.hasx as card_hasx,
	mc.isblack as card_isblack,
	mc.isblue as card_isblue,
	mc.iscolorless as card_iscolorless,
	mc.isgreen as card_isgreen,
	mc.isred as card_isred,
	mc.iswhite as card_iswhite,
	mc.typed as card_typed,
	mc.typedratio as card_typedratio

from wcard wc
join mtgiocardnormalized c on wc.card_cardid = c.cardid
join tappedoutcard toc on c.cardName = toc.cardName
join manacost mc on mc.manacostid = wc.manacost_manacostid