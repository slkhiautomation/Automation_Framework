Feature: API

  Scenario Outline: Validate the response code for various scenarios like checking "<http_code>" status code
    Given I should see response code "<http_code>" for the requested API "<Endpoint>"
    Examples:
      | Endpoint   | http_code |
      | GetAllecho |   200 	   |