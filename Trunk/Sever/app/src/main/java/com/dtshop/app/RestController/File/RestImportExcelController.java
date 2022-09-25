package com.dtshop.app.RestController.File;

import com.dtshop.app.Dto.AdministrativeUnitDto;
import com.dtshop.app.Import.ImportDataFromExcel;
import com.dtshop.app.Service.AdministrativeUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/import/")
public class RestImportExcelController {
    @Autowired
    private AdministrativeUnitService administrativeUnitService;

    @RequestMapping(value = "/administrative_unit", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> importAdministrativeUnit(@RequestParam("upload") MultipartFile multipartFile)
        throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(multipartFile.getBytes());
        List<AdministrativeUnitDto> listAdministrativeUnits = ImportDataFromExcel.importAdministrative(bis);
        this.administrativeUnitService.saveList(listAdministrativeUnits);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
