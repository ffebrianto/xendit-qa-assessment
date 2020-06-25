Feature: Test online calculator scenarios
  Scenario Outline: Test subtraction, division and CE functionalities
    Given Open chrome browser and start application
    When I enter following values and press CE button
      |value1 | <value1>|
      |value2 | <value2>|
      |operator | <operator>|
    Then I should be able to see
      |	expected |<expected>|
    Examples:
      | value1  		| value2 		| operator			| expected	|
      | 	4 			|   2			|		/			| 2			|
      | 	8 			|   0.2			|		/			| 40		|
      | 	-2 			|   5			|		/			| -0.4		|
      | 	999999999 	|   0.00000001	|		/			| 10e+16	|
      | 	999999999	|   2			|		/			|500 000 000|
      | 	1	        |   3			|		/			| 0.33333333|
      | 	1	        |   999999999	|		/			| 1e-9      |
      | 	2 			|   0			|		/			| Error		|
      | 	0 			|   0			|		/			| Error		|
      | 	-5 			|   5			|		-			| -10		|
      | 	0 			|   0			|		-			| 0 		|
      | 	10 			|   0.5			|		-			| 9.5		|
      | 	999999999	|   0.5			|		-			|999 999 999|
      | 	-999999999	|   999999999	|		-			| -2e+9		|
      | 	0.00000001	|   -0.00000002	|		-			| -1e-8		|