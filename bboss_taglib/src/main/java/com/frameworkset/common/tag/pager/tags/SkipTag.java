/*
 *  Pager Tag Library
 *
 *  Copyright (C) 2002  James Klicman <james@jsptags.com>
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.frameworkset.common.tag.pager.tags;

import java.io.OutputStream;

public final class SkipTag extends SkipTagSupport {

	private int pages = 0;

	public final void setPages(int value) {
	    pages = value;
	}

	public final int getPages() {
	    return pages;
	}

	protected boolean skip() {
		long skipPage = pagerContext.getPageNumber() + pages;

		boolean hasPage = pagerContext.hasPage(skipPage);
		if (hasPage)
			setPageAttributes(skipPage);

		return hasPage;
	}

	public void release() {
		pages = 0;
		super.release();
	}

	/* (non-Javadoc)
	 * @see com.frameworkset.common.tag.BaseTag#generateContent()
	 */
	public String generateContent() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.frameworkset.common.tag.BaseTag#write(java.io.OutputStream)
	 */
	public void write(OutputStream output) {
		// TODO Auto-generated method stub

	}
}

/* vim:set ts=4 sw=4: */
