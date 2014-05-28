package modules

import geb.Module;

class PersonRow extends Module {
	static content = {
		cell { $("td", it) }
		cellText { cell(it).text() }
        cellHrefText{ cell(it).find('a').text() }
		enabled { Boolean.valueOf(cellHrefText(0)) }
		firstName { cellText(1) }
		lastName { cellText(2) }
		showLink(to: ShowPage) { cell(0).find("a") }
	}
}