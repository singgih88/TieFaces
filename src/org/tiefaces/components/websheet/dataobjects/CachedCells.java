/*
 * Copyright 2015 TieFaces.
 * Licensed under MIT
 */
package org.tiefaces.components.websheet.dataobjects;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.tiefaces.components.websheet.TieWebSheetBean;
import org.tiefaces.components.websheet.service.CellUtility;

/**
 * Use to cache formula cells. The purpose is to compare current cell with
 * cached one. If they are different, then mean need to refresh them. All cached
 * cells are in current display sheet.
 * 
 * @author Jason Jiang
 *
 */
public class CachedCells {

	/** logger. */
	private final static Logger log = Logger.getLogger(
			Thread.currentThread().getStackTrace()[0].getClassName());

	/** The cached map. */
	private Map<Cell, FormulaMapping> cachedMap = new HashMap<Cell, FormulaMapping>();

	/** The parent. */
	private TieWebSheetBean parent = null;

	/**
	 * Instantiates a new cached cells.
	 *
	 * @param pparent
	 *            the parent
	 */
	public CachedCells(final TieWebSheetBean pparent) {
		this.parent = pparent;
		log.fine("CachedCells Constructor");
	}

	/**
	 * Put.
	 *
	 * @param cell
	 *            the cell
	 * @param cellType
	 *            the cell type
	 */
	public void put(final Cell cell, final Integer cellType) {
		Map<Cell, FormulaMapping> map = cachedMap;
		// if cellType not null then only specified Type will be put into Cache
		// e.g. only formula cell will be cached then pass in
		// Cell.CELL_TYPE_FORMULA
		if ((cell != null) && ((cellType == null)
				|| (cell.getCellType() == cellType))) {
			// String refName = TieWebSheetUtility.getFullCellRefName(sheet1,
			// cell);
			String value = CellUtility.getCellValueWithFormat(cell,
					parent.getFormulaEvaluator(),
					parent.getDataFormatter());
			FormulaMapping f = map.get(cell);
			if (f == null) {
				f = new FormulaMapping();
			}
			f.setValue(value);
			map.put(cell, f);
			log.fine("put cache key= " + cell.getAddress() + " value = "
					+ value);
		}
	}

	/**
	 * Put.
	 *
	 * @param cell
	 *            the cell
	 * @param originFormula
	 *            the origin formula
	 */
	public void put(final Cell cell, final String originFormula) {
		Map<Cell, FormulaMapping> map = cachedMap;
		// if cellType not null then only specified Type will be put into Cache
		// e.g. only formula cell will be cached then pass in
		// Cell.CELL_TYPE_FORMULA
		if ((cell != null) && (originFormula != null)) {
			FormulaMapping f = map.get(cell);
			if (f == null) {
				f = new FormulaMapping();
			}
			f.setOriginFormula(originFormula);
			String value = CellUtility.getCellValueWithFormat(cell,
					parent.getFormulaEvaluator(),
					parent.getDataFormatter());
			f.setValue(value);
			map.put(cell, f);
			log.fine("put cache key= " + cell.getAddress()
					+ " origin formula = " + originFormula + " value = "
					+ value);
		}
	}

	/**
	 * Gets the value.
	 *
	 * @param cell
	 *            the cell
	 * @return the value
	 */
	public String getValue(final Cell cell) {
		return cachedMap.get(cell).getValue();
	}

	/**
	 * Clear.
	 */
	public void clear() {
		cachedMap.clear();
		log.fine("cache cleared");
	}

	/**
	 * Checks if is value changed.
	 *
	 * @param sheet1
	 *            the sheet 1
	 * @param cell
	 *            the cell
	 * @return true, if is value changed
	 */
	public boolean isValueChanged(final Sheet sheet1, final Cell cell) {
		String newValue = CellUtility.getCellValueWithFormat(cell,
				parent.getFormulaEvaluator(), parent.getDataFormatter());
		return isValueChanged(sheet1, cell, newValue);
	}

	/**
	 * Checks if is value changed.
	 *
	 * @param sheet1
	 *            the sheet 1
	 * @param cell
	 *            the cell
	 * @param pnewValue
	 *            the new value
	 * @return true, if is value changed
	 */
	public boolean isValueChanged(final Sheet sheet1, final Cell cell,
			final String pnewValue) {
		Map<Cell, FormulaMapping> map = cachedMap;
		String oldValue = map.get(cell).getValue();
		String newValue = pnewValue;
		if (oldValue == null) {
			oldValue = "";
		}
		if (newValue == null) {
			newValue = "";
		}
		if (!oldValue.equals(newValue)) {
			return true;
		}
		return false;
	}

	/**
	 * Gets the cached map.
	 *
	 * @return the cached map
	 */
	public Map<Cell, FormulaMapping> getCachedMap() {
		return cachedMap;
	}

}
