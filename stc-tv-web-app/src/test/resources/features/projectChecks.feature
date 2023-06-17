Feature: project stability checks
  we need to check that the project is stable and run normally if there is any updates in its structure

  @CheckStability
  Scenario: check the stability of the project
    Given initialize the project
    Then close the project
