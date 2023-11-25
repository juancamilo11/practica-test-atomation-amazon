const reporter = require("cucumber-html-reporter");

const options = {
  theme: "bootstrap",
  jsonFile: "../target/cucumber.json", // Replace with the path to your cucumber.json file
  output: `report-${new Date()}.html`, // Replace with the desired output path for the HTML report
  reportSuiteAsScenarios: true,
  scenarioTimestamp: true,
  launchReport: true,
  metadata: {
    "App Version": "1.0.0",
    "Test Environment": "STAGING",
    Browser: "Chrome  119.0.3493.106",
    Platform: "Ubuntu",
    Parallel: "Scenarios",
    Executed: "Local",
  },
};

reporter.generate(options);
