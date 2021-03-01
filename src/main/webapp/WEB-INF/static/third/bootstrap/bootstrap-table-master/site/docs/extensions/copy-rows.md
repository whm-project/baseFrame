---
layout: docs
title: Table Copy Rows
description: Table Copy Rows extension of Bootstrap Table.
group: extensions
toc: true
---

This extension adds functionality for copying selected data to the clipboard. Currently works on all desktop browsers except safari.

## Usage

{% highlight html %}
<script src="extensions/copy-data/bootstrap-table-copy-data.js"></script>
{% endhighlight %}

## Example

[Copy Rows](https://examples.bootstrap-table.com/#extensions/copy-data.html)

## Options

### showCopyRows

- **Attribute:** `data-show-copy-data`

- **type:** `Boolean`

- **Detail:**

   Set `true` to show the copy button. This button copy the contents of the selected data to the clipboard.

- **Default:** `false`

### copyDelimiter

- **Attribute:** `data-copy-delimiter`

- **type:** `String`

- **Detail:**

   This delimiter will be inserted in-between the column values when copying.

- **Default:** `', '`

### copyNewline

- **Attribute:** `data-copy-newline`

- **type:** `String`

- **Detail:**

   This newline will be inserted in-between the row values when copying.

- **Default:** `'\n'`

### copyWithHidden

- **Attribute:** `data-copy-width-hidden`

- **type:** `Boolean`

- **Detail:**

   Set `true` to copy with hidden columns.

- **Default:** `false`

### Icons

- copy: 'fa-copy'

## Methods

### copyColumnsToClipboard

* Copy the contents of the selected data to the clipboard.

## Localizations

### formatCopyRows

- **type:** `Function`

- **Default:** `function () { return "Copy Rows" }`