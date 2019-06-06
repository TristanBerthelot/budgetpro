/*-------------------------------
	REQUETES GENERIQUES AJAX
 --------------------------------*/

/**
 * Récupération de données.
 * @param url : adresse de la ressource à récupérer
 * @param callback : fonction appelée en cas de succès
 * @returns
 */
function ajaxGet(url, callback) {
    const req = new XMLHttpRequest();
    req.open("GET", url);
    req.onload = function() {
    	if (req.readyState === 4) {
    		if (req.status >= 200 && req.status < 400)
                callback(req.responseText);
            else
                console.error(req.status + " " + req.statusText + " " + url);
    	}
    };
    req.onerror = function() {
        console.error("Erreur réseau avec l'URL " + url);
    };
    req.send(null);
}


/**
 * Envoi de données.
 * @param url : adresse de destination
 * @param data : données à envoyer
 * @param callback : fonction à exécuter en cas de succès
 * @param isJson : précise si les données sont au format JSON
 * @returns
 */
function ajaxPost(url, data, callback, isJson) {
    const req = new XMLHttpRequest();
    req.open("POST", url);
    req.onload = function() {
    	if (req.readyState === 4) {
    		if (req.status >= 200 && req.status < 400)
                callback(req.responseText);
            else
                console.error(req.status + " " + req.statusText + " " + url);
    	}
    };
    req.onerror = function() {
        console.error("Erreur réseau avec l'URL " + url);
    };
    if (isJson) {
        //Définit le contenu de la requête comme étant du JSON
        req.setRequestHeader("Content-type", "application/json");
        
        //Transforme la donnée du format JSON vers le format texte avant l'envoi
        data = JSON.stringify(data);
    }
    req.send(data);
}