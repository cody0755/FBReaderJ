package org.zlibrary.text.model.impl;

import org.zlibrary.text.model.entry.ZLTextParagraphEntry;

import java.util.Map;
import java.util.HashMap;

class ZLTextControlEntryPoolImpl {
	public static ZLTextControlEntryPoolImpl myPool;
	private Map<Byte, ZLTextParagraphEntry> myStartEntries;
	private Map<Byte, ZLTextParagraphEntry> myEndEntries;

	ZLTextControlEntryPoolImpl() {
		myStartEntries = new HashMap<Byte, ZLTextParagraphEntry>();
		myEndEntries = new HashMap<Byte, ZLTextParagraphEntry>();
	}

	public ZLTextParagraphEntry getControlEntry(byte kind, boolean isStart) {
		Map<Byte, ZLTextParagraphEntry> entries = isStart ? myStartEntries : myEndEntries;
		ZLTextParagraphEntry entry = entries.get(kind);
		if (entry != null) {
			return entry;
		}
		entry = new ZLTextControlEntryImpl(kind, isStart);
		entries.put(kind, entry);
		return entry;
	}
}
