function saveAuthToCookie(value) {
	document.cookie = `waiting_auth=${value}`;
}

function saveUserToCookie(value) {
	document.cookie = `userEmail=${value}`;
}

function getAuthFromCookie() {
	return document.cookie.replace(
		/(?:(?:^|.*;\s*)waiting_auth\s*=\s*([^;]*).*$)|^.*$/,
		'$1',
	);
}

function getUserFromCookie() {
	let match = document.cookie.match(
		new RegExp('(^| )' + 'userEmail' + '=([^;]+)'),
	);
	if (match) return match[2];
}

function deleteCookie(value) {
	document.cookie = `${value}=; expires=Thu, 01 Jan 1970 00:00:01 GMT;`;
}

export {
	saveAuthToCookie,
	saveUserToCookie,
	getAuthFromCookie,
	getUserFromCookie,
	deleteCookie,
};
