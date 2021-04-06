package csui.advpro2021.tais.service;

import csui.advpro2021.tais.model.Mahasiswa;
import csui.advpro2021.tais.model.MataKuliah;
import csui.advpro2021.tais.repository.MahasiswaRepository;
import csui.advpro2021.tais.repository.MataKuliahRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class MahasiswaServiceImplTest {
    @Mock
    private MahasiswaRepository mahasiswaRepository;

    @Mock
    private MataKuliahRepository mataKuliahRepository;

    @InjectMocks
    private MahasiswaServiceImpl mahasiswaService;

    @InjectMocks
    private MataKuliahServiceImpl mataKuliahService;

    private Mahasiswa mahasiswa;
    private MataKuliah matkul;

    @BeforeEach
    public void setUp(){
        mahasiswa = new Mahasiswa();
        mahasiswa.setNpm("1906192052");
        mahasiswa.setNama("Maung Meong");
        mahasiswa.setEmail("maung@cs.ui.ac.id");
        mahasiswa.setIpk("4");
        mahasiswa.setNoTelp("081317691718");

        matkul = new MataKuliah();
        matkul.setKodeMatkul("ADVPROG");
        matkul.setNama("Advanced Programming");
        matkul.setProdi("Ilmu Komputer");
    }

    @Test
    public void testServiceCreateMahasiswa(){
        lenient().when(mahasiswaService.createMahasiswa(mahasiswa)).thenReturn(mahasiswa);
    }

    @Test
    public void testServiceGetListMahasiswa(){
        Iterable<Mahasiswa> listMahasiswa = mahasiswaRepository.findAll();
        lenient().when(mahasiswaService.getListMahasiswa()).thenReturn(listMahasiswa);
        Iterable<Mahasiswa> listMahasiswaResult = mahasiswaService.getListMahasiswa();
        Assertions.assertIterableEquals(listMahasiswa, listMahasiswaResult);
    }

    @Test
    public void testServiceGetMahasiswaByNpm(){
        lenient().when(mahasiswaService.getMahasiswaByNPM("1906192052")).thenReturn(mahasiswa);
        Mahasiswa resultMahasiswa = mahasiswaService.getMahasiswaByNPM(mahasiswa.getNpm());
        assertEquals(mahasiswa.getNpm(), resultMahasiswa.getNpm());
    }

    @Test
    public void testServiceDeleteMahasiswa(){
        mahasiswaService.createMahasiswa(mahasiswa);
        mahasiswaService.deleteMahasiswaByNPM("1906192052");
        lenient().when(mahasiswaService.getMahasiswaByNPM("1906192052")).thenReturn(null);
        assertEquals(null, mahasiswaService.getMahasiswaByNPM(mahasiswa.getNpm()));
    }

    @Test
    public void testServiceUpdateMahasiswa(){
        mahasiswaService.createMahasiswa(mahasiswa);
        String currentIpkValue = mahasiswa.getIpk();
        //Change IPK from 4 to 3
        mahasiswa.setIpk("3");

        lenient().when(mahasiswaService.updateMahasiswa(mahasiswa.getNpm(), mahasiswa)).thenReturn(mahasiswa);
        Mahasiswa resultMahasiswa = mahasiswaService.updateMahasiswa(mahasiswa.getNpm(), mahasiswa);

        assertNotEquals(resultMahasiswa.getIpk(), currentIpkValue);
        assertEquals(resultMahasiswa.getNama(), mahasiswa.getNama());
    }

    @Test
    public void testServiceEnrollMatkul(){
        lenient().when(mahasiswaRepository.findByNpm(mahasiswa.getNpm())).thenReturn(mahasiswa);
        lenient().when(mataKuliahRepository.findByKodeMatkul(matkul.getKodeMatkul())).thenReturn(matkul);

        lenient().when(mahasiswaService.enrollMataKuliah(mahasiswa.getNpm(), matkul.getKodeMatkul())).thenReturn(mahasiswa);
        Mahasiswa resultMahasiswa = mahasiswaService.enrollMataKuliah(mahasiswa.getNpm(), matkul.getKodeMatkul());

        assertEquals(resultMahasiswa.getNama(), mahasiswa.getNama());
    }
}
