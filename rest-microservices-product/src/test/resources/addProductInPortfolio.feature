Feature: Adding the product in the right risk bucket
  In order to make an informed decision
  As an individual investor
  I want to know the risk of the products I'm interested in

  Background:
    Given the rating associated to the countries are as follows :
    |country   |rating| shouldOverride|
    |  FRA     |  1   |     false     |
    |  USA     |  2   |     false     |
    |  JAP     |  4   |     false     |
    |  IND     |  3   |     true      |
    |  GER     |  1   |     true      |
    |  ITA     |  5   |     true      |

  Scenario: Depending on their characteristics, products will be added in a different bucket of the portfolio,
  based on the inherent risk that is computed. Below are overall rules :
    -> country : 1=High, 2-3=Medium, 4-5=Low
    -> volatility : A-B=High, C-D=Medium, E=Low
    Whichever is highest risk between the 2 will be overall risk level for the product,
  unless country is flagged as overriding  in that case, country will take precedence

    Given I am interested in these products :
    |productName|issuingCountry|volatilityIndex|
    |	ISIN123	|	FRA	       |	A	|
    |	ISIN456	|	FRA	       |	C	|
    |	ISIN789	|	FRA	       |	E	|
    |	ISIN987	|	USA	       |	B	|
    |	ISIN654	|	USA	       |	D	|
    |	ISIN321	|	USA	       |	E	|
    |	ISIN741	|	JAP		   |	A	|
    |	ISIN852	|	JAP		   |	D	|
    |	ISIN963	|	JAP		   |	E	|
    |	ISIN147	|	GER	       |	A	|
    |	ISIN258	|	GER	       |	C	|
    |	ISIN369	|	GER	       |	E	|
    |	ISIN753	|	IND	       |	B	|
    |	ISIN159	|	IND	       |	D	|
    |	ISIN951	|	IND	       |	E	|
    |	ISIN357	|	ITA	       |	A	|
    |	ISIN486	|	ITA	       |	D	|
    |	ISIN426	|	ITA	       |	E	|

    When I add them in my portfolio
    Then the products are allocated in these risk buckets :
    |productName|riskBucket |comment                                                       |
    |	ISIN123	|	HIGH	| country and volatility = high -> high                        |
    |	ISIN456	|	HIGH	| country = high > volatility = medium                         |
    |	ISIN789	|	HIGH	| country = high > volatility = low                            |
    |	ISIN987	|	HIGH	| country =  medium < volatility =  high                       |
    |	ISIN654	|	MEDIUM	| country and volatility = medium -> medium                    |
    |	ISIN321	|	MEDIUM	| country =  medium > volatility =  low                        |
    |	ISIN741	|	HIGH	| country =  low < volatility =  high                          |
    |	ISIN852	|	MEDIUM	| country =  low < volatility =  medium                        |
    |	ISIN963	|	LOW	    | country and volatility = low -> low                          |
    |	ISIN147	|	HIGH	| country (with override) and volatility = high -> high        |
    |	ISIN258	|	HIGH	| country (with override) = high > volatility = medium         |
    |	ISIN369	|	HIGH	| country (with override) = high > volatility = low            |
    |	ISIN753	|	MEDIUM	| country (with override) =  medium > volatility =  medium     |
    |	ISIN159	|	MEDIUM	| country (with override) and volatility = medium -> medium    |
    |	ISIN951	|	MEDIUM	| country (with override) =  medium > volatility =  low        |
    |	ISIN357	|	LOW	    | country (with override) =  low > volatility =  high          |
    |	ISIN486	|	LOW	    | country (with override) =  low > volatility =  medium        |
    |	ISIN426	|	LOW	    | country (with override) and volatility = low -> low          |
