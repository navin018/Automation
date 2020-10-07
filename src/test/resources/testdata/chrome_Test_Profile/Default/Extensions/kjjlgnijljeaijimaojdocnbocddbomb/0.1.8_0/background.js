/*
    Anurag Bhandari
    BetaTeam
    https://beta.accenture.com/
    November, 2014
    "Remember, remember, the fifth of November."
*/

// Get a reference to this extension's manifest
var manifest = chrome.runtime.getManifest();

// Pick the URLs permission from the manifest
var allowedURLs = manifest.permissions[2];

// Set a request filter to make this extension work with only a specific set of URLs
var requestFilter = {
    urls: [
        allowedURLs
    ]
};

// Set the browser action button as per stored value for isACNUserAgentEnabled
updateBrowserAction();


// Modify the user-agent string before the HTTP headers are sent to the server
chrome.webRequest.onBeforeSendHeaders.addListener(function (details) {
	
    // Modify user agent only if the feature is not manually turned off by user
    if( getIsACNUserAgentEnabled() != "false" ) {
		
        for (var i = 0; i < details.requestHeaders.length; ++i) {
		
            if (details.requestHeaders[i].name === 'User-Agent') {
                details.requestHeaders[i].value += ' managedpc (Accenture)';
                break;
            }
        }
    }
    
    return {
        requestHeaders: details.requestHeaders
    };

}, requestFilter, ['requestHeaders', 'blocking']);



// Called when the user clicks on the browser action.
chrome.browserAction.onClicked.addListener(function (tab) {

    // Toggle the isACNUserAgentEnabled bit
    window.localStorage.setItem("isACNUserAgentEnabled", getIsACNUserAgentEnabled() == "true" ? "false" : "true");

    // Update the browser action
    updateBrowserAction();

});



// Update the browser action icon and title
function updateBrowserAction() {
    var buttonTitle = "Disable Accenture SignOn";
    var buttonIcon = "images/icon-48.png";
    if( getIsACNUserAgentEnabled() == "false" ) {
        buttonTitle = "Enable Accenture SignOn";
        buttonIcon = "images/gray-icon-48.png";
    }
    chrome.browserAction.setTitle({
        title: buttonTitle 
    });
    chrome.browserAction.setIcon({
        path: buttonIcon
    });
}



// Get the stored value (string) of isACNUserAgentEnabled localStorage variable
function getIsACNUserAgentEnabled() {
    var isACNUserAgentEnabled = window.localStorage.getItem("isACNUserAgentEnabled");
    isACNUserAgentEnabled = isACNUserAgentEnabled == null ? "true" : isACNUserAgentEnabled;
    return isACNUserAgentEnabled;
}