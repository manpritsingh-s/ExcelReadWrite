import copy
import os
import xlrd
import xlwt

file_path = "test.xls"

if os.path.exists(file_path):
    
    book = xlrd.open_workbook(file_path, formatting_info=True)
    sheet = book.sheet_by_index(0)
    writeable = copy(book)
    writeable_sheet = writeable.get_sheet(0)

    last_row = sheet.nrows

else:
    book = xlwt.Workbook()
    sheet = book.add_sheet("Sheet 1")
    last_row = 0
    
writeable_sheet.write(last_row, 0, "Build Successful")
    
writeable_book.write(file_path)
print("Build Successful message written to", file_path)
